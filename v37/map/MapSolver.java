package map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import blocks.Block;
import blocks.ClosedBlock;
import blocks.GoalBlock;
import blocks.GoalBlock;
import blocks.StartBlock;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MapSolver {
	
	static Map map;
	static int steps = 0;
	static boolean solution = false;
	
	static ArrayList<Circle> path = new ArrayList<Circle>();
	
	public MapSolver(int startX, int startY, Map map) {
		
	}

	public static void Solver(Map map) {
		MapSolver.map = map;
		
		int startX = map.getStartX();
		int startY = map.getStartY();
		
		
		solve(startX, startY, 1); //Upp
		solve(startX, startY, 2); //Höger
		solve(startX, startY, 3); //Vänster
		solve(startX, startY, 4); //Ner
		
		}
	
	public static void solve(int x, int y, int d) {
		
		Block b = map.getBlock(x, y);
		
		if (b instanceof GoalBlock) {
			solution = true;
			return;
		}
		
		if (b instanceof ClosedBlock || b == null || solution) {
			return;
			
		}
		
		double cirkelStorlek = Block.SIZE / 2;
		
		path.add(
				new Circle(x * Block.SIZE + cirkelStorlek, y * Block.SIZE + cirkelStorlek, cirkelStorlek, Color.BLUE));
	
			if (b instanceof GoalBlock) {
				
				System.out.println("Den har tagit" + " " + steps + " " + "steg");//Vissar hur många steg man den har tagit	
			}
			
		steps++;
		if (d == 1) { //upp
			solve(x, y - 1, 1);
			solve(x, y - 1, 4);
			solve(x, y - 1, 2);
		}
		
		if (d == 2) { //höger
			solve(x + 1, y, 2);
			solve(x + 1, y, 1);
			solve(x + 1, y, 3);
		}
		
		if (d == 3) { //vänster
			solve(x, y + 1, 3);
			solve(x, y + 1, 4);
			solve(x, y + 1, 2);
		}
		
		if (d == 4) { //ner
			solve(x - 1, y, 1);
			solve(x - 1, y, 3);
			solve(x - 1, y, 4);
			}
		 			
		}
	}
	
	
	
	
