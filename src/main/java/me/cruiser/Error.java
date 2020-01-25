package me.cruiser;

public class Error {
    public static void fooError() throws Exception {
        System.out.println("call fooError");
        if (false) {
            throw new Exception();
        }
    }
    public static void main(String[] args) throws Exception {
        try {
            fooError();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void foo() {

            bar();

    }

    private void bar() {
        throw new IllegalArgumentException();
    }
}
