package application.com;

import java.util.ListResourceBundle;

public class MyResources_en_GB extends ListResourceBundle {
	private SessionModel model = new SessionModel(); 
	private String[] quotes = { "The best preparation for tomorrow is doing your best today. - Jackson Brown",
			"Whatever you are, be a good one. - Abraham Lincoln",
			"If you dream it, you can do it. - Walt Disney",
			"Never, never, never give up. - Winston Churchill",
			"Do not wait. The time will never be just right. - Napoleon Hill",
			"If not us, who? If not now, when? - John F. Kennedy",
			"Everything you can imagine is real. - Pablo Picasso",
			"I can, therefore I am. - Simone Weil",
			"To Will is to Be - Tadiwa Mahlunge",
			"Remember no one can make you feel inferior without your consent. - Eleanor Roosevelt",
			"Turn your wounds into wisdom. - Oprah Winfrey",
			"Wherever you go, go with all your heart. - Confucius",
			"Do what you can, with what you have, where you are. - Theodore Roosevelt",
			"Hope is a waking dream. - Aristotle",
			"Action is the foundational key to all success. - Pablo Picasso",
			"Do one thing every day that scares you. - Eleanor Roosevelt",
			"You must do the thing you think you cannot do. - Eleanor Roosevelt",
			"Life is trying things to see if they work. - Ray Bradbury",
			"Do not regret the past, just learn from it. - Ben Ipock",
			"Believe you can and you are halfway there. - Theodore Roosevelt",
			"Live what you love. - Jo Deurbrouck",
			"The power of imagination makes us infinite. - John Muir",
			"May you live every day of your life. - Jonathan Swift",
			"Eighty percent of success is showing up. - Woody Allen",
			"To be the best, you must be able to handle the worst. - Wilson Kanadi",
			"A jug fills drop by drop. - Buddha",
			"The obstacle is the path. - Zen Proverb",
			"The best revenge is massive success. - Frank Sinatra",
			"The best way out is always through. - Robert Frost",
			"Hope is the heartbeat of the soul. - Michelle Horst",
			"Ever tried. Ever failed. No matter. Try Again. Fail again. Fail better. - Samuel Beckett",
			"We become what we think about. - Earl Nightingale",
			"An obstacle is often a stepping stone. - Prescott Bush",
			"Dream big and dare to fail. -Norman Vaughan",
			"Men are born to succeed, not fail. - Henry David Thoreau"
	};
	
	private Object[][] contents = {
      {"model", model},
      {"quotes", quotes}
	};
	/**
	 * This will return the contents of this application's resource bundle.
	 * @return contents The contents of the Resource Bundle.
	 */
  protected Object[][] getContents() {
      return contents;
  }
}
