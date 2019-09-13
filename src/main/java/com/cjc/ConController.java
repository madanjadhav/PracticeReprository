package com.cjc;

import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cjc.model.Student;

@RestController
@RequestMapping("consumer")
public class ConController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{id}")
	public Object getsingledata(@PathVariable int id){
		System.out.println(id);
		//String url="http://localhost:8085/pro/"+id;
		String url="http://localhost:8085/pro/{id}";
		Map<String, Integer> m=new HashMap<String, Integer>();
		m.put("id", id);
		Object object=restTemplate.getForObject(url, Object.class,m);
		System.out.println(object);
		return object;
		
	}
	
	@GetMapping("/")
	public List<Object> getall(){
		
		String url="http://localhost:8085/pro/";
		
		List<Object> list=restTemplate.getForObject(url, List.class);
		return list;
		
	}
	
	@GetMapping("/byname/{name}")
	public Object byname(@PathVariable String name){
		
		String url="http://localhost:8085/pro/byname/{name}";
		Map<String, String> m=new HashMap<String, String>();
		m.put("name",name);
		
		Object o2=restTemplate.getForObject(url, Object.class, m);
		//Object o=restTemplate.getForObject(url, Object.class);
		return o2;
		
	}
	
	@PutMapping("/")
	public Student update(@RequestBody Student student){
		
		String url="http://localhost:8085/pro/";
		HttpEntity<Student> entity=new HttpEntity<Student>(student);
		//Map<String, Student> m=new HashMap<String, Student>();
		Student s=restTemplate.postForObject(url, entity, Student.class);
		return s;
		
	}
	
	@DeleteMapping("/{rollno}")
	public void delete(@PathVariable int rollno){
		
		String url="http://localhost:8085/pro/{rollno}";
		Map<String, Integer> m=new HashMap<String, Integer>();
		m.put("rollno", rollno);
		restTemplate.delete(url, m);
		
	}
	
	@GetMapping(value="/image",produces="!application/json")
	public Object showimage(){
		System.out.println("image url");
		String url="https://www.google.co.in/imgres?imgurl=https%3A%2F%2Fimages.pexels.com%2Fphotos%2F736230%2Fpexels-photo-736230.jpeg%3Fauto%3Dcompress%26cs%3Dtinysrgb%26dpr%3D1%26w%3D500&imgrefurl=https%3A%2F%2Fwww.pexels.com%2Fsearch%2Fflower%2F&docid=5UbOpOqf9qM23M&tbnid=uj16sHyiOXWEWM%3A&vet=10ahUKEwis6dmlzbvkAhXGknAKHcWlAQYQMwh8KAEwAQ..i&w=500&h=750&hl=en&authuser=0&bih=754&biw=1536&q=flower%20images&ved=0ahUKEwis6dmlzbvkAhXGknAKHcWlAQYQMwh8KAEwAQ&iact=mrc&uact=8";
		Object o=restTemplate.getForObject(url, Object.class);
		return o;
		
	}
}
