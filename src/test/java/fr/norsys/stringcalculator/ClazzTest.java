package fr.norsys.stringcalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClazzTest{


    @Test
    public void should_return_0(){
        Clazz example =new Clazz();
        assertEquals(0,example.add(""));
    }
    @Test
    public void should_return_4(){
        Clazz example =new Clazz();
        assertEquals(4,example.add("4"));
    }
    @Test
    public void should_return_the_sum_of_two(){
        Clazz example =new Clazz();
        assertEquals(6,example.add("2,4"));
    }
    @Test
    public void should_return_the_sum_of_many(){
        Clazz example =new Clazz();
        assertEquals(20,example.add("2,4,5,7,2"));
    }
    @Test
    public void should_return_the_sum_with_many_delimiters(){
        Clazz example =new Clazz();
        assertEquals(20,example.add("2\n4,5\n7,2"));
    }
    @Test
    public void should_return_the_sum_with_variable_delimiter(){
        Clazz example =new Clazz();
        assertEquals(16,example.add("//;\n2;5;7;2"));
    }
    @Test
    public void should_return_throw_runtimeException(){
        Clazz example =new Clazz();
        RuntimeException re =assertThrows(RuntimeException.class,()-> example.add("2,-4,5,-7,2"));
        assertEquals("negatives not allowed - [-4, -7]",re.getMessage());
    }
    @Test
    public void should_skip_numbers_bigger_than_1000(){
        Clazz example =new Clazz();
        assertEquals(2,example.add("1200,2"));
    }



}