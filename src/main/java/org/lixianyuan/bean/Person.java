package org.lixianyuan.bean;

/**
 * @Aauthor xianyuan_li@qq.com
 * @Date: Create in 21:28 2019/6/30
 * @Description: Person bean
 */
public class Person {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person(){
        super();
    }

    //从写toString方法，打印当前类对象的时候相当于调用toString方法
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
