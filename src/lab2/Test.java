package lab2;

//++++++++++++++++++++++++++++++++
interface IFunc {
    int getF();
}

interface IConst {
    int verConst = 100;
}

//+++++++++++++++++++++++++++++++++
interface IConst11 {
    int verConst = 101;
}

interface IConst22 {
    int verConst = 102;
}

interface IConstT extends IConst11, IConst22 {
    int verConst = 100;

    int get(boolean b);
}

class Test {
    public static void main(String[] args) {
        SuperClass supC = new SuperClass(5, true);// Создать объект суперкласса
        System.out.println("supC.x= " + supC.x + " supC.b= " + supC.getB());
        // Создать объект подкласса
        SubClass subC = new SubClass(55, 555, false);
        // Получить объект данных
        Dan d = subC.get();
        System.out.println("subC.x= " + d.xSub + " supC.x= " + d.xSup + " subC.b= " + d.b);
    }
}

class Dan {
    public int xSup, xSub;
    public boolean b;

    public Dan(int Xsub, int Xsup, boolean B) {
        xSub = Xsub;
        xSup = Xsup;
        b = B;
    }
}

class SuperClass {
    int x;
    private final boolean b;

    public SuperClass(int X, boolean B) {
        x = X;
        b = B;
    }

    public boolean getB() {
        return b;
    }
}

class SubClass extends SuperClass {// Подкласс (sub class)
    int x;

    public SubClass(int Xsup, int Xsub, boolean B) // Конструктор
    {
        super(Xsub, B); // Вызов конструктора базового класса
        x = Xsup;
    }

    // Получить объект типа Dan с данными
    public Dan get() {
        return new Dan(x, super.x, super.getB());
    }
}

class ClassInt implements IFunc, IConst {
    public int getF() {
        return verConst;
    }
}

class TestInterface {
    public static void main(String[] args) {
        ClassInt cI = new ClassInt();
        System.out.println("verConst= " + cI.getF());
        IFunc iF = cI;
        IConst iC = cI;
        System.out.println("verConst= " + iF.getF());
        // System.out.println ("verConst= " + iC.getF()); // Error
        // Cannot find 'getF()' in 'IConst'
        System.out.println("verConst= " + iC.verConst);
        System.out.println("verConst= " + ClassInt.verConst);
    }
}

class ClassIntT implements IConstT {
    public int get(boolean b) {
        return b ? IConst11.verConst : IConst22.verConst;
    }
}

class TestInterface2 {
    public static void main(String[] args) {
        ClassIntT cI = new ClassIntT();
        System.out.print("cI.verConst= " + cI.verConst);
        System.out.println(" ClassInt.verConst= " + ClassInt.verConst);
        //-----
        IConst11 iC1 = cI;
        System.out.print("iC1.verConst= " + iC1.verConst);
        IConst22 iC2 = cI;
        System.out.print(" iC2.verConst= " + iC2.verConst);
        IConstT iC = cI;
        System.out.println(" iC.verConst= " + iC.verConst);
        //--------------
        System.out.print("IConst1.verConst= " + IConst11.verConst);
        System.out.print(" IConst2.verConst= " + IConst22.verConst);
        System.out.println(" IConst.verConst= " + IConst.verConst);
        //--------------
        System.out.println("cI.get(true)= " + cI.get(true) + " cI.get(false)= " + cI.get(false));
    }
}

//++++++++++++++++++++++++++++++++
class TestExc {
    static void Func() {
        int m = 10, n = 0;
        n = m / n;
    }

    public static void main(String[] args) {
        try {
            Func();
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException happened");
        } catch (Exception e) {
            System.out.println("Exception happened");
        } finally {
            System.out.println("finally");
        }
    }
}

//+++++++++++++++++++++++++++++
class MyException extends Exception {
    //public MyException () {}
    public String toString() {
        return "MyException happened";
    }
}

class TestMyExc {
    static void Func() throws MyException {
        int m = 0, n = 10;
        if ((m / n) == 0) throw new MyException();
        System.out.print("Next");
    }

    public static void main(String[] args) {
        try {
            Func();
        } catch (MyException e) {
            System.out.println(e);
        }
    }
}