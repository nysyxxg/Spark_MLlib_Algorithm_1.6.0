package com.fz.classification

import java.io.File

import com.fz.util.Utils
import org.junit.Assert._
import org.junit.Test

/**
 * 测试RidgeAndLassoRegression算法
 *
 * Created by cuihuan on 2017/1/12.
 */
@Test
class RidgeAndLassoRegressionTest {

  @Test
  def testMain1()={
    //    testOrNot input minPartitions output targetIndex " +
    //    "splitter numIteration stepSize regParam miniBatchFraction hasIntercept regressionType
    val args = Array(
      "true",
      "./src/data/classification_regression/lpsa.dat",
      "2",
      "./target/ridgeAndLassoRegression/tmp1",
      "1",
      " ",
      "30",
      "1.0",
      "0.01",
      "1.0",
      "true",
//      "RIDGE"
      "LASSO"
    )
    // 删除输出目录
    Utils.deleteOutput(args(3))
    RidgeAndLassoRegression.main(args)
    assertTrue(Utils.fileContainsClassName(args(3)+"/metadata/part-00000",
      "org.apache.spark.mllib.regression.LassoModel"))
  }
  @Test
  def testMain2()={
    //    testOrNot input minPartitions output targetIndex " +
    //    "splitter numIteration stepSize regParam miniBatchFraction hasIntercept regressionType
    val args = Array(
      "true",
      "./src/data/classification_regression/lpsa.dat",
      "2",
      "./target/ridgeAndLassoRegression/tmp2",
      "1",
      " ",
      "30",
      "1.0",
      "0.01",
      "1.0",
      "true",
           "RIDGE"
      //"LASSO"
    )
    // 删除输出目录
    Utils.deleteOutput(args(3))
    RidgeAndLassoRegression.main(args)
    assertTrue(Utils.fileContainsClassName(args(3)+"/metadata/part-00000",
      "org.apache.spark.mllib.regression.RidgeRegressionModel"))
  }
}
