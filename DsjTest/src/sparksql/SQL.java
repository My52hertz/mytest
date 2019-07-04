package sparksql;

import org.apache.spark.SparkConf;
import org.apache.spark.SparkContext;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.rdd.RDD;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.DateType;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;
import scala.Function1;

import java.util.Arrays;
import java.util.List;


/**
 * @author sunyi,
 * @date 2019/6/12,
 * @time 10:31,
 */
public class SQL {
    public static void main(String[] args){
        SparkConf sparkConf = new SparkConf();
        sparkConf.setAppName("hertz").setMaster("local");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        javaSparkContext.setLogLevel("WARN");
        SQLContext sqlContext = new SQLContext(javaSparkContext);
        JavaRDD<String> stringJavaRDD = javaSparkContext.textFile("./Txt/word.txt");
        JavaRDD<Row> map = stringJavaRDD.map(new Function<String, Row>() {
            @Override
            public Row call(String s) throws Exception {


                return RowFactory.create(s.split(" ")[0], s.split(" ")[1]);
            }
        });
        List<StructField> list = Arrays.asList(DataTypes.createStructField("word",DataTypes.StringType,true),DataTypes.createStructField("num",DataTypes.StringType,true));
        StructType schema = DataTypes.createStructType(list);
        DataFrame dataFrame = sqlContext.createDataFrame(map, schema);
        dataFrame.registerTempTable("hertz");
        sqlContext.sql("select distinct(count(word)),count(num) from hertz").show();




    }
}
