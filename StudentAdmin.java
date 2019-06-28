package com.ecjtu.zwh;

import java.util.Scanner;

public class StudentAdmin {
    String msg=" 编号 \t 姓名 \t 年龄 \tjava \tcsharp \thtml \tsql \t 总分  \t 平均分";
    //打印学生
    public void print(Student[] stu){
        System.out.println(msg);
        for (int i=0;i<stu.length;i++){
            if (stu[i]!=null){
                System.out.println(stu[i]);
            }
        }
    }
    //添加学生
    public void addStudent(String name,int age,Student [] stu){
        Student student=new Student();
        student.setName(name);
        student.setAge(age);
        int i=this.getIndex(stu);
        if (i>=9999)
        {
            System. out .println( " 数组已经容纳最大量，不能再接受 " );
        }
        else {
            student.setId(i);
        }
        stu[i]=student;

    }
    //获取编号
    public int getIndex(Student[] stu){
        for ( int i=0;i<stu. length ;i++)
        {
            if (stu[i]== null )
            {
                return i;
            }
        }
        return 9999;
    }
    //根据编号查找学生
    public void selectStudent(int id,Student[] stu){
        System.out.println(msg);
        for (int i=0;i<stu.length;i++){
            if(id==stu[i].getId()){
                System.out.println(stu[i]);
                return;
            }
        }
        System.out.println("没有找到这个学生");
    }
    //更新学生数据
    public void updateStudent(int id,String name,int age,Student[] stu){
        for (int i=0;i<stu.length;i++){
            if (stu[i]!=null){
                if (id==stu[i].getId()){
                    stu[i].setAge(age);
                    stu[i].setName(name);
                    System.out.println("更新成功");
                    return;
                }
            }
        }
    }
    //根据编号删除学生
    public void deleteStudent(int id,Student[] stu){
        for (int i=0;i<stu.length;i++){
            if (id==stu[i].getId()){
                stu[i]=null;
                this.print(stu);
                System.out.println("删除学生成功");
            }
        }
        System.out.println("删除失败");
    }
    //根据学生编号获得名字
    public String getStudentName(int id,Student[] stu){
        for (int i=0;i<stu.length;i++){
            if (id==stu[i].getId()){
                return stu[i].getName();
            }
        }
        return null;
    }
    //根据学生编号输入成绩
    public void inputScore(int id , Student[] stu, Scanner input){
        System.out.println("请输入java成绩:");
        int java=input.nextInt();
        System.out.println("请输入csharp成绩:");
        int csharp=input.nextInt();
        System.out.println("请输入html成绩:");
        int html=input.nextInt();
        System.out.println("请输入sql成绩:");
        int sql=input.nextInt();
        for (int i=0;i<stu.length;i++){
            if (id==stu[i].getId()){
                stu[i].setJava(java);
                stu[i].setCsharp(csharp);
                stu[i].setHtml(html);
                stu[i].setSql(sql);
                stu[i].setSum();
                stu[i].setAvg();
                break;
            }
        }
        this.print(stu);
    }

    //按某一门成绩来排序
    public void socreSort(int num,Student[] stu){
        Student[]arr=stu;
        if (num==1){
            for (int i=0;i<arr.length-1;i++){
                for (int j=i+1;j<arr.length;j++){
                    if (arr[i]!=null&&arr[j]!=null){
                        if (arr[i].getJava()<arr[j].getJava()){
                            Student s=arr[i];
                            arr[j]=arr[i];
                            arr[i]=s;
                        }
                    }
                }
            }
            this.print(arr);
        }
        else if (num==2){
            for (int i=0;i<arr.length-1;i++){
                for (int j=i+1;j<arr.length;j++){
                    if (arr[i]!=null&&arr[j]!=null){
                        if (arr[i].getCsharp()<arr[j].getCsharp()){
                            Student s=arr[i];
                            arr[j]=arr[i];
                            arr[i]=s;
                        }
                    }
                }
            }
            this.print(arr);
        }
        else if (num==3){
            for (int i=0;i<arr.length-1;i++){
                for (int j=i+1;j<arr.length;j++){
                    if (arr[i]!=null&&arr[j]!=null){
                        if (arr[i].getHtml()<arr[j].getHtml()){
                            Student s=arr[i];
                            arr[j]=arr[i];
                            arr[i]=s;
                        }
                    }
                }
            }
            this.print(arr);
        }
        else if (num==4){
            for (int i=0;i<arr.length-1;i++){
                for (int j=i+1;j<arr.length;j++){
                    if (arr[i]!=null&&arr[j]!=null){
                        if (arr[i].getSql()<arr[j].getSql()){
                            Student s=arr[i];
                            arr[j]=arr[i];
                            arr[i]=s;
                        }
                    }
                }
            }
            this.print(arr);
        }

    }
    //按总分排序
    public void sumSort(Student [] stu){
        Student []arr=stu;
        for (int i=0;i<arr.length-1;i++){
            for (int j=i+1;j<arr.length;j++){
                if (arr[i]!=null&&arr[j]!=null){
                    if (arr[i].getSum()<arr[j].getSum()){
                        Student s=arr[i];
                        arr[j]=arr[i];
                        arr[i]=s;
                    }
                }
            }
        }
        this.print(arr);
    }
}
