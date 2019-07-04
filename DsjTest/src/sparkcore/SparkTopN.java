package sparkcore;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.api.java.function.VoidFunction;
import scala.Tuple2;

import java.util.Iterator;

/**
 * @author sunyi,
 * @date 2019/6/3,
 * @time 10:14,
 */
public class SparkTopN {

    public static void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("hertz").setMaster("local");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        javaSparkContext.setLogLevel("WARN");
        JavaRDD<String> stringJavaRDD = javaSparkContext.textFile("./Txt/sort.txt");
        JavaPairRDD<String, Iterable<Integer>> stringIterableJavaPairRDD = stringJavaRDD.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String arg0) throws Exception {
                return new Tuple2<String, Integer>(arg0.split("\t")[0], Integer.valueOf(arg0.split("\t")[1]));
            }
        }).groupByKey();

        stringIterableJavaPairRDD.foreach(new VoidFunction<Tuple2<String, Iterable<Integer>>>() {
            @Override
            public void call(Tuple2<String, Iterable<Integer>> stringIterableTuple2) throws Exception {
                Iterator<Integer> iterator = stringIterableTuple2._2.iterator();
                String s = stringIterableTuple2._1;
                Integer[] integers1 = new Integer[3];
                while (iterator.hasNext()){
                    Integer next = iterator.next();

                    for (int i = 0;i<integers1.length;i++){
                        if (integers1[i] == null){
                            integers1[i] = next;
                            break;
                        }else if (next > integers1[i]){
                            for (int j = 2;j>i;j--){
                                integers1[j] = integers1[j-1];
                            }
                            integers1[i] = next;
                            break;
                        }


                    }

                }
                System.out.println("class = "+s);
                for(Integer in :integers1){
                    System.out.println(in);
                }
            }
        });
    }
}
