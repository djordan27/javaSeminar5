import java.util.ArrayList;
import java.util.HashMap;


class Food
{
    public final String name;
    public Food(String name)
    {
        this.name = name;
    }


    private static final int
            FRUIT = 1,
            VEGETABLE = 2;

    private static final HashMap<Integer, ArrayList<Food>> typeToFood = new HashMap<>();

    public static void main(String[] args)
    {
        add(FRUIT, new Food("apple"));
        add(FRUIT, new Food("orange"));
        add(VEGETABLE, new Food("potato"));
        add(VEGETABLE, new Food("carrot"));
        for (int type : typeToFood.keySet())
        {
            for (Food food : typeToFood.get(type))
            {
                System.out.print(food.name + " ");
            }
            System.out.println();
        }
        System.out.println(typeToFood);
    }

    private static void add(int type, Food food)
    {
        if (!typeToFood.containsKey(type))
        {
            typeToFood.put(type, new ArrayList<Food>());
        }
        typeToFood.get(type).add(food);
    }
}