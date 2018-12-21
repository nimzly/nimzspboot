package io.nimz.springboot.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(new Topic("1", "Java", "1-Description"),
			new Topic("2", "NodeJS", "2-Description"), new Topic("3", "Swift", "3-Description")));

	public List<Topic> getAllTopics() {

		// return topics;

		List<Topic> topicz = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topicz::add);
		return topicz;
	}

	public Topic getTopicById(String id) {
		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findById(id).get();

	}

	public void addTopic(Topic topic) {

		// topics.add(topic);

		topicRepository.save(topic);

	}

	public void deleteTopicById(String id) {
		/*
		 * for (int i = 0; i < topics.size(); i++) { if
		 * (topics.get(i).getId().equals(id)) { topics.remove(i); return; } }
		 */
		// OR Lambda way

		// topics.removeIf(t -> t.getId().equals(id));

		topicRepository.deleteById(id);

	}

	public void updateTopic(String id, Topic topic) {
		/*
		 * for (int i = 0; i < topics.size(); i++) { if
		 * (topics.get(i).getId().equals(id)) { topics.set(i, topic); return; } }
		 */

		topicRepository.save(topic);

	}
}
