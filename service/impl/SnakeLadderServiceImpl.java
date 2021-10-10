/**
 * @author Shivshankar
 * on 10-Oct-2021
 */
package com.machinecode.snakeladder.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.machinecode.snakeladder.model.SnakeLadder;
import com.machinecode.snakeladder.service.SnakeLadderService;
import com.machinecode.snakeladder.util.Dice;

public class SnakeLadderServiceImpl implements SnakeLadderService {

	@Override
	public void start(SnakeLadder input) {
		System.out.println("Starting with the game...");
		Map<Integer, Integer> snakes = input.getSnakes();
		Map<Integer, Integer> ladders = input.getLadders();
		Map<Integer, String> players = input.getPlayers();
		int numberOfPlayers = players.keySet().size();
		int numberOfCells = input.getNumberOfCells();
		int playerPosition[] = new int[numberOfPlayers];
		Arrays.fill(playerPosition, 0);
		Map<Integer, Boolean> playerReached = new HashMap<>();
		while(playerReached.size() != numberOfPlayers - 1) {
			for (int i = 0; i < numberOfPlayers; i++) {
				if (!playerReached.getOrDefault(i+1, false) && playerReached.size() != numberOfPlayers - 1) {
					int roll = Dice.roll();
					int currentPosition = playerPosition[i];
					int nextPosition = currentPosition + roll;
					nextPosition = checkForLadderOrSnake(
						nextPosition,
						ladders,
						snakes
					);
					if (nextPosition <= numberOfCells) {
						playerPosition[i] = nextPosition;
					}
					if (playerPosition[i] == numberOfCells) {
						playerReached.put(i+1, true);
						System.out.println("**** " + players.get(i+1) + " has rolled " + roll + " and won the game! Rank: "+(playerReached.size())+" ****");
						continue;
					} else {
						System.out.println(
							players.get(i+1) +
							" rolled " + roll +
							" and moved from " + currentPosition +
							" to " + playerPosition[i]
						);
					}
				}
			}
		}

	}

	private int checkForLadderOrSnake(
		int nextPosition,
		Map<Integer, Integer> ladders,
		Map<Integer, Integer> snakes
	) {
		if (ladders.containsKey(nextPosition)) {
			return checkForLadderOrSnake(ladders.get(nextPosition), ladders, snakes);
		} else if (snakes.containsKey(nextPosition)) {
			return checkForLadderOrSnake(snakes.get(nextPosition), ladders, snakes);
		}
		return nextPosition;
	}
}
