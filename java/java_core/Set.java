/*
Set: 无序, 不可以重复元素.
  |--HashSet:数据结构是哈希表,线程是非同步的.判断元素唯一性的原理:判断元素的HashCode值是否相同, 如果相同,还会继续判断 元素equals方法,  是否是true.

  |--TreeSet:可对Set集合中的元素进行排序.
      底层数据结构是二叉树. 保证元素唯一性的依据: CompareTo方法返回 return 0.
      TreeSet排序的第一种方式: 让元素自身具备比较性. 元素需要实现Comparable接口, 覆盖compareTo方法. 这种方式也称为元素自然排序,
      第二种排序方式: 当元素自身不具备比较性,或具备的比较性不是需要的. 这时需要让集合自身具备比较性.  在集合初始化时,就有了比较方式. 定义比较器,
      将比较器作为参数传递给TreeSet集合的构造函数.

*/
package com.hk.temp;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;


class Student implements Comparable{//该接口强制让学生具备比较性。
	private String name;
	private int age;
	Student(String name, int age){
		this.name=name;
		this.age=age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public int compareTo(Object obj) {
	//return 0；
		if(!(obj instanceof Student))
			throw new RuntimeException("不是学生对象");
		Student s=(Student)obj;
		System.out.println(this.name+"....compareto....…"+s.name);
		if(this.age>s.age)
			return 1;
		if(this.age==s.age)	{
			return this.name.compareTo(s.name);
		return-1;
/**/
			}
	}
}

class TreesetDemo{
	public static void main(String[] args) {
		TreeSet ts = new TreeSet(new MyCompare() );
		ts. add(new Student("lisi02", 22));
		ts. add(new Student("lisi007", 20));
		ts. add(new Student("lisi09", 19));
		ts. add(new Student("lisi01", 40));

		Iterator it = ts. iterator();
		while (it. hasNext()) {
			Student stu = (Student) it. next();
			System. out. println(stu.getName() + "..…" + stu.getAge());
		}
	}
}

class MyCompare implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student)o1;
		Student s2 = (Student)o2;
		int num = s1. getName(). compareTo(s2. getName());
		if (num == 0)
			return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
		return num;
	}
}
