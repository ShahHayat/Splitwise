package com.makhdoom.Splitwise;

import com.makhdoom.Splitwise.commands.CommandExecutor;
import com.makhdoom.Splitwise.commands.CreateUserCommand;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Scanner;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseApplication implements CommandLineRunner {

	private Scanner scanner;
	private CommandExecutor commandExecutor;

	public SplitwiseApplication(CommandExecutor commandExecutor, CreateUserCommand createUserCommand) {
		this.scanner = new Scanner(System.in);
		this.commandExecutor = commandExecutor;
		this.commandExecutor.addCommand(createUserCommand);
	}

	public static void main(String[] args) {
		SpringApplication.run(SplitwiseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true) {
			System.out.println("Enter input: ");
			String input = scanner.nextLine();
			commandExecutor.execute(input);
		}
	}
}
