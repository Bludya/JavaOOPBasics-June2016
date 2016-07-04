package bg.softuni.io.commands;

import bg.softuni.exceptions.InvalidCommandException;
import bg.softuni.io.IOManager;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

/**
 * Created by Bludya on 4.7.2016 г..
 * All rights reserved!
 */
public abstract class Command {
    private String input;
    private String[] data;
    private StudentsRepository repository;
    private Tester tester;
    private IOManager ioManager;
    private DownloadManager downloadManager;

    protected Command(String input,
                      String[] data,
                      StudentsRepository repository,
                      Tester tester,
                      IOManager ioManager,
                      DownloadManager downloadManager) {
        this.setInput(input);
        this.setData(data);
        this.setRepository(repository);
        this.setTester(tester);
        this.setIoManager(ioManager);
        this.setDownloadManager(downloadManager);
    }

    protected String getInput() {
        return input;
    }

    private void setInput(String input) {
        if (input == null || input.equals("")) {
            throw new InvalidCommandException(input);
        }
        this.input = input;
    }

    protected String[] getData() {
        return data;
    }

    private void setData(String[] data) {
        if (data == null || data.length < 1) {
            throw new InvalidCommandException(input);
        }
        this.data = data;
    }

    protected StudentsRepository getRepository() {
        return repository;
    }

    private void setRepository(StudentsRepository repository) {
        this.repository = repository;
    }

    protected Tester getTester() {
        return tester;
    }

    private void setTester(Tester tester) {
        this.tester = tester;
    }

    protected IOManager getIoManager() {
        return ioManager;
    }

    private void setIoManager(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    protected DownloadManager getDownloadManager() {
        return downloadManager;
    }

    private void setDownloadManager(DownloadManager downloadManager) {
        this.downloadManager = downloadManager;
    }

    public abstract void execute() throws Exception;
}
