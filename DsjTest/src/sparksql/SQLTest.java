package sparksql;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.Arrays;
import java.util.List;

/**
 * @author sunyi,
 * @date 2019/6/3,
 * @time 11:01,
 */
public class SQLTest {
    public static  void main(String[] args) {
        SparkConf sparkConf = new SparkConf();
        sparkConf.setMaster("local").setAppName("hertz");
        JavaSparkContext javaSparkContext = new JavaSparkContext(sparkConf);
        SQLContext sqlContext = new SQLContext(javaSparkContext);
        JavaRDD<String> stringJavaRDD = javaSparkContext.textFile("./Txt/persion");
        JavaRDD<Row> map = stringJavaRDD.map(new Function<String, Row>() {
            @Override
            public Row call(String s) throws Exception {
                return RowFactory.create(s.split(",")[0], s.split(",")[1], Integer.valueOf(s.split(",")[2]));
            }
        });
        List<StructField>  arg0 = Arrays.asList(DataTypes.createStructField("id",DataTypes.StringType,true),DataTypes.createStructField("name",DataTypes.StringType,true),DataTypes.createStructField("age",DataTypes.IntegerType,true));
        StructType schema = DataTypes.createStructType(arg0);
        DataFrame dataFrame = sqlContext.createDataFrame(map, schema);
        dataFrame.registerTempTable("hertz");
        DataFrame sql = sqlContext.sql("select * from hertz");

        sql.show();


    }
}
