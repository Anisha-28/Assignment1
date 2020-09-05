import javax.swing.JOptionPane;

class Stage3 {
	// Stage 3
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "Chatbot Stage 3...\nTopic input-taking phase...");

		// a. Ask the user to enter each topic that the chatbot will look for in the
		// conversation.
		int numTopics = Integer.parseInt(JOptionPane.showInputDialog("How many topics?"));
		while (numTopics < 1) {
			numTopics = Integer.parseInt(JOptionPane.showInputDialog("Error! Enter a positive number of topics"));
		}

		String[] topics = new String[numTopics];
		String allTopics = "";
		int i = 0;
		while (i < numTopics) {
			topics[i] = JOptionPane.showInputDialog("Enter topic " + (i + 1));
			if (i == 0)
				allTopics += topics[i];
			else
				allTopics += ", " + topics[i];
			i += 1;
		}

		JOptionPane.showMessageDialog(null, "Chatting phase...");

		String tellMeMore = "Tell me more about ";
		// b. Ask the user to say something about a known topic (must show them the
		// built-in topics in
		// the input prompt). (Stage 3 must use a loop here).
		String prompt = "";
		String input = "";
		prompt += tellMeMore + allTopics;

		input = JOptionPane.showInputDialog(prompt);
		while (input != null) {

			prompt = "";
			// c. If the (most recently entered) user input contains a question mark
			// anywhere, chatbot must say it'll ask the questions.
			if (input.contains("?"))
				prompt += "I'll be asking the questions...\n";

//		d. If a known topic is in the entered user input, chatbot must ask the user about that topic.
//		E.g. if the user entered “i want to talk about work and stuff” and if “work” is a matching topic,
//		chatbot must ask them “Tell me more about work...”. (Note: recognised topic must
//		be in the prompt when asking). Hint: There is no need to recognise more than one topic from a
//		single input. You will need to investigate within the Java String class documentation to use
//		either or contains, indexOf methods to achieve this task.

			i = 0;
			while (i < numTopics && !input.contains(topics[i])) {
				i += 1;
			}
			if (i < numTopics) // If array end not reached but loop finished, we know we came across a topic
				prompt += tellMeMore + topics[i];

			else { // Reached the end of the array with no matches
					// e. If the (most recently entered) input contains no known topic, chatbot
					// must show an
					// appropriate response (indicating that it didn’t understand, etc.) and repeat
					// from b.
				prompt += "I didn't understand that.\n" + tellMeMore + allTopics;
			}
			input = JOptionPane.showInputDialog(prompt);
		}
	}

}
