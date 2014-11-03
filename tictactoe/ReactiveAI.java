package tictactoe;

import java.util.ArrayList;

public class ReactiveAI extends AI implements Player {

	private Human reactiveAgent;
	private double basePerfection, maxPerfection;

	public ReactiveAI(char playerChar, char opponentChar, 
					  double basePerfection, double maxPerfection, Human reactiveAgent) {
		super(playerChar, opponentChar);
		this.basePerfection = basePerfection;
		this.maxPerfection = maxPerfection;
		this.reactiveAgent = reactiveAgent;
	}

	public int makeMove(Grid grid) {
		ArrayList<Integer>[] moves = getMoves(grid);
		ArrayList<Integer> negMoves = new ArrayList<Integer>();
		for(int i = 0; i < 9; i++) {
			if(!moves[0].contains(i) && !moves[1].contains(i) && grid.isVacant(i))
				negMoves.add(i);
		}
		if(reactivePerfection() > Math.random()) {  // perfect move
			if(!moves[1].isEmpty())
				return moves[1].get((int)(Math.random() * moves[1].size()));
			if(!moves[0].isEmpty())
				return moves[0].get((int)(Math.random() * moves[0].size()));
			return negMoves.get((int)(Math.random() * negMoves.size()));
		}
		if(!negMoves.isEmpty()) {
			if(!moves[0].isEmpty() && !moves[1].isEmpty()) 
				negMoves.addAll(moves[0]);
			return negMoves.get((int)(Math.random() * negMoves.size()));
		}
		if(!moves[0].isEmpty())
			return moves[0].get((int)(Math.random() * moves[0].size()));
		return moves[1].get((int)(Math.random() * moves[1].size()));
	}

	private double reactivePerfection() {
		return (maxPerfection - basePerfection) * reactiveAgent.getPerfection() + basePerfection;
	}
}