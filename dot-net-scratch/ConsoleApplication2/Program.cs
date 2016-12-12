using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication2
{
    class Program
    {
        static void Main(string[] args)
        {
            int sampleSize = 50000000;
            double[] arrayToTest = new double[sampleSize];
            Random rand = new System.Random();

            for (int i = 0; i < sampleSize; i++)
            {
                arrayToTest[i] = rand.NextDouble();
            }

            Stopwatch sw = new Stopwatch();

            sw.Start();
            double result = Double.MinValue;
            for (int i = 0; i < sampleSize; i++)
            {
                if (arrayToTest[i] > result)
                {
                    result = arrayToTest[i];
                }
            }
            sw.Stop();
            System.Console.WriteLine("Array performance: " + sw.Elapsed.TotalMilliseconds +" ms.  Final result: " + result);

            sw.Reset();
            sw.Start();
            result = Double.MinValue;
            for (int i = 0; i < sampleSize; i++)
            {
                if (arrayToTest[i] > result)
                {
                    result = arrayToTest[i];
                }
            }
            sw.Stop();
            System.Console.WriteLine("Array performance 2nd run: " + sw.Elapsed.TotalMilliseconds + " ms.  Final result: " + result);

            sw.Restart();
            result = arrayToTest.Max();
            sw.Stop();
            System.Console.WriteLine("Array.Max() performance: " + sw.Elapsed.TotalMilliseconds + " ms.  Final result: " + result);

            sw.Reset();
            List<Double> list = arrayToTest.ToList<Double>();
            sw.Start();
            result = Double.MinValue;
            for (int i = 0; i < sampleSize; i++)
            {
                if (list[i] > result)
                {
                    result = list[i];
                }
            }
            sw.Stop();
            System.Console.WriteLine("List performance: " + sw.Elapsed.TotalMilliseconds + " ms.  Final result: " + result);

            sw.Restart();
            result = list.Max();
            sw.Stop();
            System.Console.WriteLine("List.Max() performance: " + sw.Elapsed.TotalMilliseconds + " ms.  Final result: " + result);



            System.Console.ReadLine();
        }
    }
}
