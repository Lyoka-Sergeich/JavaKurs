package Hwk1;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> ins;

    Box(){
        this.ins = new ArrayList<>();
    }

    //кладём в коробку
    public void putInBox(T frt){
        this.ins.add(frt);
    }

    //взвешиваем коробку
    public float getWeight(){
        float res = 0;
        for (T el:ins){
            res += el.weight;
        }
        return res;
    }

    //пересыпаем коробку в другую
    public void putAllInBox(Box otherBox){
        if(this.ins.size() == 0){  //высыпать нечего
            System.out.println("This box is empty!");
            return;
        }
        if(otherBox.ins.size() == 0){  //высыпаем в пустую коробку
            otherBox.ins = this.ins;
            int n = this.ins.size();
            for (int i = 0; i < n; i++) {
                this.ins.remove(0);
            }
            System.out.println("The fruits are replaced!");
            return;
        }

        if(otherBox.ins.get(0).getClass() != this.ins.get(0).getClass()){   //проверим содержимое другой коробки
            System.out.println("There are not equal fruits in boxes!");
        }
        else{
            int n = this.ins.size();
            otherBox.ins.ensureCapacity(n);
            otherBox.ins = this.ins;
            for (int i = 0; i < n; i++) {
                otherBox.ins.add(this.ins.get(0));
                this.ins.remove(0);
            }
            System.out.println("The fruits are replaced!");
        }
    }

    //сравниваем коробку по весу с другой
    public boolean compare(Box otherBox){
        if(Math.abs(this.getWeight() - otherBox.getWeight()) < 0.01)
            return true;
        else
            return false;
    }
}
