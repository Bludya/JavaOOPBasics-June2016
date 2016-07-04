package bg.softuni.io;

import bg.softuni.exceptions.InvalidCommandException;
import bg.softuni.io.commands.*;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.StudentsRepository;

import java.io.IOException;

public class CommandInterpreter {
    private Tester tester;
    private StudentsRepository studentsRepository;
    private DownloadManager downloadManager;
    private IOManager inputOutputManager;

    public CommandInterpreter(Tester tester, StudentsRepository studentsRepository, DownloadManager downloadManager, IOManager ioManager) {
        this.tester = tester;
        this.studentsRepository = studentsRepository;
        this.downloadManager = downloadManager;
        this.inputOutputManager = ioManager;
    }

    public void interpretCommand(String input) throws IOException {
        String[] data = input.split("\\s+");
        String commandName = data[0].toLowerCase();
        try {
            Command command = parseCommand(input, data, commandName);
            command.execute();
        } catch (Throwable t) {
            OutputWriter.displayException(t.getMessage());
        }
    }

    private Command parseCommand(String input, String[] data, String command) throws IOException {
        switch (command) {
            case "open":
                return new OpenFileCommand(input, data, this.studentsRepository, this.tester,
                        this.inputOutputManager, this.downloadManager);
            case "mkdir":
                return new MakeDirectoryCommand(input, data, this.studentsRepository, this.tester,
                        this.inputOutputManager, this.downloadManager);
            case "ls":
                return new TraverseFoldersCommand(input, data, this.studentsRepository, this.tester,
                        this.inputOutputManager, this.downloadManager);
            case "cmp":
                return new CompareFilesCommand(input, data, this.studentsRepository, this.tester,
                        this.inputOutputManager, this.downloadManager);
            case "cdrel":
                return new ChangeRelativePathCommand(input, data, this.studentsRepository, this.tester,
                        this.inputOutputManager, this.downloadManager);
            case "cdabs":
                return new ChangeAbsolutePathCommand(input, data, this.studentsRepository, this.tester,
                        this.inputOutputManager, this.downloadManager);
            case "readdb":
                return new ReadDatabaseCommand(input, data, this.studentsRepository, this.tester,
                        this.inputOutputManager, this.downloadManager);
            case "dropdb":
                return new DropDatabaseCommand(input, data, this.studentsRepository, this.tester,
                        this.inputOutputManager, this.downloadManager);
            case "help":
                return new GetHelpCommand(input, data, this.studentsRepository, this.tester,
                        this.inputOutputManager, this.downloadManager);
            case "show":
                return new ShowCourseCommand(input, data, this.studentsRepository, this.tester,
                        this.inputOutputManager, this.downloadManager);
            case "filter":
                return new PrintFilteredStudentsCommand(input, data, this.studentsRepository, this.tester,
                        this.inputOutputManager, this.downloadManager);
            case "order":
                return new PrintOrderedStudentsCommand(input, data, this.studentsRepository, this.tester,
                        this.inputOutputManager, this.downloadManager);
            case "download":
                return new DownloadFileCommand(input, data, this.studentsRepository, this.tester,
                        this.inputOutputManager, this.downloadManager);
            case "downloadasynch":
                return new DownloadAsynchCommand(input, data, this.studentsRepository, this.tester,
                        this.inputOutputManager, this.downloadManager);
            default:
                throw new InvalidCommandException(input);
        }
    }
}
