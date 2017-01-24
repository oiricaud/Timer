CS 4330/5390: Mobile Application Development
======

Group Work: GUI Programming
(File $Date: 2017/01/19 19:23:07 $)

January 24, 2017

Names: Oscar Ivan Ricaud

Work in a group of two to write a very simple "timer" applet. The
applet should consist of three GUI components: a text field to display
the elapse time in the hh:mm:ss format and start and stop buttons to
start and stop the timer (see a demo).

Do it incrementally.
  P1: GUI only consisting of a text field and two buttons.
      Swing features: JLabel, JButton, and layout managers like
        BorderLayout and FlowLayout

  P2: Logic for starting and stopping the timer and showing only
      the start and stop time.
      Swing features: Event, event handler and event registration
        ActionEvent, ActionListener, addActionListener
	long System.currentTimeMillies()
 
  P3: Display the elapsed time continuously.
      Swing features: Single threadness
        Timer class: Timer(int, ActionListener), start(), stop()
        or SwingUtilities.invokeLater(Runnable)

Evaluation

(a) Was your group able to write code for?
    P1:   Yes 
    P2:   Yes 
    P3:   Yes 

(2) If not, state briefly the challenges or problems that your group
    encountered along with your plan to address them.
