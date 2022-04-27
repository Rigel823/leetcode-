# 883.三维形体投影面积20220426

## 一、题目描述

![image-20220426164315537](D:\AhhhXYQ\ReadNotes\Note_pic\image-20220426164315537.png)

![image-20220426164327681](D:\AhhhXYQ\ReadNotes\Note_pic\image-20220426164327681.png)

## 二、题目分析

### 方法一：数学

x轴——行；y轴——列；z轴——对应网格的数值

xy平面投影面积——网格上非零数值的数目

yz平面投影面积——网格上每一列最大数值之和

zx平面投影面积——网格上每一行最大数值之和

```java
class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int xyArea = 0, yzArea = 0, zxArea = 0;
        for (int i = 0; i < n; i++) {
            int yzHeight = 0, zxHeight = 0;
            for (int j = 0; j < n; j++) {
                xyArea += grid[i][j] > 0 ? 1 : 0;//有多少不是0的格子就有多大面积
                yzHeight = Math.max(yzHeight, grid[j][i]);
                zxHeight = Math.max(zxHeight, grid[i][j]);//调转行列坐标
            }
            yzArea += yzHeight;
            zxArea += zxHeight;
        }
        return xyArea + yzArea + zxArea;
    }
}
```



