package com.example.demo;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ItemInitializer implements CommandLineRunner {

	private final ItemRepository itemRepository;

	public ItemInitializer(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Lining", "PUMA", "Bad Boy", "Air Jordan", "Nike", "Adidas", "Reebok")
				.forEach(name -> itemRepository.save(new Item(null, name)));

		itemRepository.findAll().forEach(System.out::println);
	}
}
