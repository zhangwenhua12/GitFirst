package com.ecjtu.zwh;

import java.util.Scanner;

public class TestStudent {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        System.out.println("请输入学生个数:");
        int studengtnum=in.nextInt();
        StudentAdmin admin=new StudentAdmin();//实例化对象
        Student []students=new Student[studengtnum];//初始化学生数组
       while (true){
           System.out.println("选择要执行的功能输入编号");
           System.out.println("10：添加一个学生");
           System.out.println("11：查找一个学生");
           System.out.println("12：根据学生编号更新学生信息");
           System.out.println("13：根据学生编号删除学生");
           System.out.println("14：根据编号输入学生各科成绩");
           System.out.println("15：根据某门成绩进行排序");
           System.out.println("16：根据总分进行排序");
           System.out.println("99：退出系统");
           Scanner in1=new Scanner(System.in);
           int type=in1.nextInt();
           switch (type){
               case 10:
                   System.out.println("--执行添加学生操作--");
                   System.out.println("请输入学生名字:");
                   String name=in.next();
                   System.out.println("请输入学生年龄:");
                   int age=in.nextInt();
                   admin.addStudent(name,age,students);
                   admin.print(students);
                   break;
               case 11:
                   System.out.println("--执行查找学生操作--");
                   System.out.println("根据编号查询学生,请输入编号:");
                   int id=in.nextInt();
                   admin.selectStudent(id,students);
                   admin.print(students);
                   break;
               case 12:
                   System.out.println("--执行更新学生数据操作--");
                   System.out.println("请输入编号更新学生信息:");
                   int id1=in.nextInt();
                   System.out.println("输入修改后的学生名字:");
                   String name1=in.next();
                   System.out.println("请输入修改后的学生年龄:");
                   int age1=in.nextInt();
                   admin.updateStudent(id1,name1,age1,students);
                   admin.print(students);
                   break;
               case 13:
                   System.out.println("--执行删除操作--");
                   System.out.println("请输入学生编号进行删除");
                   int id2=in.nextInt();
                   admin.deleteStudent(id2,students);
                   break;
               case 14:
                   System.out.println("--执行输入学生成绩操作--");
                   System.out.println("请输入学生编号");
                   int id3=in.nextInt();
                   admin.inputScore(id3,students,in);
                   break;
               case 15:
                   System.out.println("--执行指定成绩排序--");
                   System.out.println("输入课程编号1.Java，2.csharp，3.html,4.sql");
                   int num=in.nextInt();
                   admin.socreSort(num,students);
                   break;
               case 16:
                   System.out.println("--执行总分排序--");
                   admin.sumSort(students);
                   break;
               case 99:
                   System.exit(0);
                   break;
           }
       }
    }
}
