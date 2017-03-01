package instruction.TurtleQueries;

import java.util.List;

import instruction.InstructionData;

public class PenDown extends TurtleQuery {

	public PenDown(InstructionData instructionData, List<String> args, String myText) {
		super(instructionData, args, myText);
	}

	@Override
	public double execute() {
		return getActiveActor().getPenDown() ? 1 : 0;
	}

}
