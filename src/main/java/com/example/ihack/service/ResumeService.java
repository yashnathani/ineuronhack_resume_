package com.example.ihack.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.example.ihack.model.*;
@Service
public class ResumeService {
	 private static List<Resume> todos = new ArrayList<Resume>();
	    private static int todoCount = 3;
	    
	    static {
	        todos.add(new Resume(1, "save", "Yash","analyst","bot,webdev,appmanage" ,"springframework,ai,statistics","bengaluru","thanks"));
	        todos.add(new Resume(2,"save", "Ram","webdev","bot,webdev,datascience" ,"ai,statistics","Noida","thanks" ));
	        todos.add(new Resume(3,"save", "Shayam","datascientist","bot" ,"django,ai,statistics","Mumbai","thanks" ));
	        
	    }

	    
	    public List<Resume> retrieveTodos(String user) {
	        List<Resume> filteredTodos = new ArrayList<Resume>();
	        for (Resume todo : todos) {
	            if (todo.getUser().equals("save")) {
	                filteredTodos.add(todo);
	            }
	        }
	        return filteredTodos;
	    }

	    
	    public Resume retrieveTodo(int id) {
	        
	        for (Resume todo : todos) {
	            if (todo.getId()==id) {
	                return todo;
	            }
	        }
	        return null;
	    }
	    public void updateTodo(Resume todo)
	    {
	    	todos.remove(todo);
	    	todos.add(todo);
	    	
	    }
	    
	    
	    public void addTodo(String user, String name,String obj, String proj,String skill,String location,String regards ) {
	        todos.add(new Resume(++todoCount,user,name,obj,proj,skill,location,regards));
	    }

	    public void deleteTodo(int id) {
	        Iterator<Resume> iterator = todos.iterator();
	        while (iterator.hasNext()) {
	            Resume todo = iterator.next();
	            if (todo.getId() == id) {
	                iterator.remove();
	            }
	        }
	
}
}
