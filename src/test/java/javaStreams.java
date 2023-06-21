import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class javaStreams {

    //Count the number of names starting with the letter 'A' in the list
    public void regular() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Ajay");
        names.add("Varrsha");
        names.add("Aarav");
        names.add("Ram");
        names.add("Aaradhya");

        int count=0;
        for(int i=0;i<names.size();i++)
        {
            String actualName = names.get(i);
            if(actualName.startsWith("A"))
            {
                count++;
            }
        }

        System.out.println(count);

    }

    @Test
    public void streamFilter()
    {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Ajay");
        names.add("Varrsha");
        names.add("Aarav");
        names.add("Ram");
        names.add("Aaradhya");

        //there's no life for intermediate operations without terminal operations
        //terminal operations will execute only when there is a terminal operation
        //we can use stream() method to convert the list into a stream
        //how to filter in stream API
        Long c = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(c);

        Stream.of("Ajay","Varrsha","Aarav","Ram","Aaradhya").filter(s->
        {
            s.startsWith("A");
            return true;
        }).count();
        System.out.println(c);

        //print all the names of the list
        //names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
        names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
    }

    @Test
    public void streamMap()
    {
        ArrayList<String> names1 = new ArrayList<String>();
        names1.add("Adam");
        names1.add("Eve");
        names1.add("Noah");

        //print names of length>4 in uppercase
        //Stream.of("Ajay","Varrsha","Aarav","Ram","Aaradhya").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));

        //print names with first letter as A with uppercase and sorted
        List<String>names = Arrays.asList("Ajay","Varrsha","Aarav","Ram","Aaradhya");
        names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));

        //concatenate 2 lists
        Stream<String> newStream = Stream.concat(names.stream(),names1.stream());
        //newStream.sorted().forEach(s->System.out.println(s));

        //check if Ajay is in the list
        boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Ajay"));
        System.out.println(flag);
        Assert.assertTrue(flag);

    }

    @Test
            public void streamCollect()
    {
        List<String> ls = Stream.of("Ajay","Varrsha","Aarav","Ram","Aaradhya").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(ls.get(0));

        List<Integer> values = Arrays.asList(3,2,2,7,5,0,9,7);
        //print the unique values from this array
        //sort the array
        //values.stream().distinct().forEach(s->System.out.println(s));
        List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println(li.get(2));
    }
}
