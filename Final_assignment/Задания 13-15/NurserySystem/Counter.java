public class Counter implements AutoCloseable {
    static Integer counter = 0;

    public Counter() {
    }

    public void add() {
        Counter.counter++;
    }

    @Override
    public void close() {
        System.out.println("\nВведено новых животных за сеанс: " + Counter.counter);
    }
}