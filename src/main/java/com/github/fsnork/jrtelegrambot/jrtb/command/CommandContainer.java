package com.github.fsnork.jrtelegrambot.jrtb.command;

import com.github.fsnork.jrtelegrambot.jrtb.service.SendBotMessageService;
import com.google.common.collect.ImmutableMap;

import static com.github.fsnork.jrtelegrambot.jrtb.command.CommandName.*;

public class CommandContainer {

    private final ImmutableMap<Object, Object> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendBotMessageService sendBotMessageService) {

        commandMap = ImmutableMap.<Object, Object>builder()
                .put(START.getCommandName(), new StartCommand(sendBotMessageService))
                .put(STOP.getCommandName(), new StopCommand(sendBotMessageService))
                .put(HELP.getCommandName(), new HelpCommand(sendBotMessageService))
                .put(NO.getCommandName(), new NoCommand(sendBotMessageService))
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return (Command) commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
