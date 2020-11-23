package org.abondar.experimental.cassandrademo.command.util;


import org.abondar.experimental.cassandrademo.command.ConnectionCommand;
import org.abondar.experimental.cassandrademo.command.ConnectionListenerCommand;
import org.abondar.experimental.cassandrademo.command.SessionCommand;

public class CommandSwitcher {

    private final CommandExecutor executor;

    public CommandSwitcher() {
        this.executor = new CommandExecutor();
    }


    public void executeCommand(String cmd){
        try {
            switch (Commands.valueOf(cmd)){
                case CC:
                    ConnectionCommand cc = new ConnectionCommand();
                    executor.executeCommand(cc);
                    break;

                case CLC:
                    ConnectionListenerCommand clc = new ConnectionListenerCommand();
                    executor.executeCommand(clc);
                    break;

                case SC:
                    SessionCommand sc = new SessionCommand();
                    executor.executeCommand(sc);
                    break;

            }

        } catch (IllegalArgumentException ex){
            System.out.println("Check documentation for command list");
            System.exit(1);
        }

    }
}
