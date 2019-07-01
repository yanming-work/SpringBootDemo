/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2015 abel533@gmail.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package demo.yanming.springboot.echarts.samples.line;

import demo.yanming.springboot.echarts.axis.CategoryAxis;
import demo.yanming.springboot.echarts.axis.LogAxis;
import demo.yanming.springboot.echarts.axis.ValueAxis;
import demo.yanming.springboot.echarts.code.Magic;
import demo.yanming.springboot.echarts.code.Tool;
import demo.yanming.springboot.echarts.code.Trigger;
import demo.yanming.springboot.echarts.code.X;
import demo.yanming.springboot.echarts.feature.MagicType;
import demo.yanming.springboot.echarts.series.Line;
import demo.yanming.springboot.echarts.util.EnhancedOption;
import org.junit.Test;

/**
 * @author YanMing
 */
public class LineTest9 {

    @Test
    public void test() {
        //地址:http://echarts.baidu.com/doc/example/line9.html
        EnhancedOption option = new EnhancedOption();
        option.title().text("对数轴示例").x(X.center);


        option.legend().x(X.left).data("2的指数", "3的指数");

        option.toolbox().show(true).feature(
                Tool.mark,
                Tool.dataView,
                new MagicType(Magic.line, Magic.bar),
                Tool.restore,
                Tool.saveAsImage);
        option.tooltip().trigger(Trigger.item).formatter("{a} <br/>{b} : {c}");
        option.calculable(true);

        option.yAxis(new LogAxis());
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.name("x").splitLine().show(false);
        categoryAxis.data("一", "二", "三", "四", "五", "六", "七", "八", "九");

        option.xAxis(categoryAxis);

        ValueAxis valueAxis = new ValueAxis();
        valueAxis.axisLabel().formatter("{value} °C");
        option.xAxis(valueAxis);

        Line line = new Line("3的指数");
        line.data(1, 3, 9, 27, 81, 247, 741, 2223, 6669);
        Line line2 = new Line("2的指数");
        line2.data(1, 2, 4, 8, 16, 32, 64, 128, 256);
        option.series(line, line2);
        option.exportToHtml("line7.html");
        option.view();
    }
}
