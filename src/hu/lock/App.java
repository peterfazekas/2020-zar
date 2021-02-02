package hu.lock;

import hu.lock.controller.KeyService;
import hu.lock.model.service.*;

import java.util.Scanner;

public class App {
    
    private final KeyService keyService;
    private final Console console;
    private final DataWriter dataWriter;
    
    private App() {
        console = new Console(new Scanner(System.in));
        DataApi dataApi = new DataApi(new FileReader(), new DataParser());
        keyService = new KeyService(dataApi.getData("ajto.txt"));
        dataWriter = new DataWriter("siker.txt");
    }

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.print("2. feladat: Adja meg mi nyitja a zárat: ");
        String pattern = console.read();
        System.out.println("3. feladat: A nyitó kódszámok sorai: " + keyService.getEqualKeyIds(pattern));
        System.out.println("4. feladat: Az első ismétlődést tartalmazó próbálkozás sorszáma: " + keyService.getSameDigitKeyId());
        System.out.println("5. feladat: " + keyService.getGeneratedKey(pattern));
        dataWriter.writeAll(keyService.getOpenResults(pattern));
    }

}
