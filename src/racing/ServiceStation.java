package racing;

import racing.transport.Bus;
import racing.transport.Transport;

import java.util.ArrayDeque;

public class ServiceStation {
    private ArrayDeque<Transport> queue = new ArrayDeque<>();

    public void addTransportToQueue(Transport transport) {
        if (transport instanceof Bus) {
            System.out.println("Автобус не нуждается в техобслуживании");
            return;
        }
        queue.add(transport);
        System.out.println("Автомобиль " + transport.getBrand() + transport.getModel() +
                " добавлен в очередь на тех обслуживание.");
    }

    public void fixTransport(Transport transport) {
        Transport poll = queue.poll();
        if (poll != null) {
            poll.diagnostic();
        }
    }
}
