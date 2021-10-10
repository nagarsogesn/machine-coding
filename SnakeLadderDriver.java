/**
 * @author Shivshankar
 * on 10-Oct-2021
 */
package com.machinecode.snakeladder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.machinecode.snakeladder.model.SnakeLadderInput;
import com.machinecode.snakeladder.service.SnakeLadderService;
import com.machinecode.snakeladder.service.impl.SnakeLadderServiceImpl;

public class SnakeLadderDriver {

	private static final String FILE_NAME = "/home/shivshankar/Desktop/Flipkart/Inputs/snake_ladder_input";

	public static void main(String[] args) {
		SnakeLadderService snakeLadderService = new SnakeLadderServiceImpl();
		try {
			SnakeLadderInput input = getInput();
			snakeLadderService.start(input);
		} catch (FileNotFoundException e) {

		}

	}

	private static SnakeLadderInput getInput() throws FileNotFoundException {
		File inputFile = new File(FILE_NAME);
		Scanner scanner = new Scanner(inputFile);
		int numberOfCells = Integer.parseInt(scanner.nextLine());
		Map<Integer, Integer> ladders = getLadders(scanner);
		Map<Integer, Integer> snakes = getSnakes(scanner);
		Map<Integer, String> players = getPlayers(scanner);
		SnakeLadderInput input = new SnakeLadderInput(
			snakes,
			ladders,
			players,
			numberOfCells
		);
		scanner.close();
		return input;
	}

	private static Map<Integer, String> getPlayers(Scanner scanner) {
		String line;
		line = scanner.nextLine();
		int numberOfPlayers = Integer.parseInt(line);
		Map<Integer, String> players = new HashMap<>();
		for (int i = 0; i < numberOfPlayers; i++) {
			players.put(i+1, scanner.nextLine());
		}

		return players;
	}

	private static Map<Integer, Integer> getLadders(Scanner scanner) {
		String line;
		line = scanner.nextLine();
		int numberOfLadders = Integer.parseInt(line);
		Map<Integer, Integer> ladders = new HashMap<>();
		for (int i = 0; i < numberOfLadders; i++) {
			String ladder[] = scanner.nextLine().split(" ");
			ladders.put(Integer.parseInt(ladder[0]), Integer.parseInt(ladder[1]));
		}
		return ladders;
	}

	private static Map<Integer, Integer> getSnakes(Scanner scanner) {
		String line = scanner.nextLine();
		int numberOfSnakes = Integer.parseInt(line);
		Map<Integer, Integer> snakes = new HashMap<>();
		for (int i = 0; i < numberOfSnakes; i++) {
			String snake[] = scanner.nextLine().split(" ");
			snakes.put(Integer.parseInt(snake[0]), Integer.parseInt(snake[1]));
		}
		return snakes;
	}

}
