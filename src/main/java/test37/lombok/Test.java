package test37.lombok;

import lombok.AllArgsConstructor;

/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 4/1/18
 * Time: 8:40 PM
 * To change this template use File | Settings | File Templates.
 * Description:
 */
public class Test {

    //  lombok, 通过注解, 来省略setter getter toString的代码,
    // 需要安装插件来启用对lombok的支持

    public static void main(String[] args) {

        // @Data, 包含了@ToString、@EqualsAndHashCode、@Getter / @Setter和@RequiredArgsConstructor的功能
        // @NoArgsConstructor 添加默认构造器, @AllArgsConstructor添加所有参数的构造器
        Person p1 = new Person(1,"tom",22.22);
        System.out.println(p1.toString());

        // @Builder可以添加builder方法
        BuilderExample oldDriver = BuilderExample.builder().age(11).name("tom").occupation("driver").build();
        System.out.println(oldDriver.toString());


    }
}
