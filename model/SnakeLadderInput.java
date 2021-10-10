/**
 * @author Shivshankar
 * on 10-Oct-2021
 */
package com.machinecode.snakeladder.model;

import java.util.Map;

public class SnakeLadder {
	private int numberOfCells;
	private Map<Integer, Integer> snakes;
	private Map<Integer, Integer> ladders;
	private Map<Integer, String> players;
	public SnakeLadder(
		Map<Integer, Integer> snakes,
		Map<Integer, Integer> ladders,
		Map<Integer, String> players,
		int numberOfCells
	) {
		this.snakes = snakes;
		this.ladders = ladders;
		this.players = players;
		this.numberOfCells = numberOfCells;
	}

	public Map<Integer, Integer> getSnakes() {
		return snakes;
	}

	public Map<Integer, Integer> getLadders() {
		return ladders;
	}

	public Map<Integer, String> getPlayers() {
		return players;
	}

	public Integer getNumberOfCells() {
		return numberOfCells;
	}
}
