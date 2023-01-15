import icon from "../../assets/icons/BiAlarmExclamation.png";
import { GridItem, Grid, Heading, Text, Box } from "@chakra-ui/react";
import { useParams } from "react-router-dom";

interface ITask {
  name: string;
  id: number;
  description: string;
  question: string;
  taskDateTime: string;
  promptContext: string;
}

export const Task = ({
  name,
  description,
  question,
  taskDateTime,
  promptContext,
}: ITask) => {
  return (
    <GridItem
      bg="var(--blue-bg-300)"
      color="var(--blue-text-300)"
      p={4}
      mt={5}
      borderRadius="md"
      minWidth="clamp(300px, 50vw, 500px)"
    >
      <Heading as="h3" size="md" mb={2}>
        {name}
      </Heading>
      <div>
        <img
          src={icon}
          style={{
            width: "1em",
            aspectRatio: "1",
            display: "inline-block",
            verticalAlign: "middle",
          }}
        />
        <span
          style={{
            verticalAlign: "middle",
          }}
        >
          {taskDateTime}
        </span>
      </div>
      <Text mt={2}>{description}</Text>
      <Text mt={2}>{question}</Text>
      <Text mt={2}>{promptContext}</Text>
    </GridItem>
  );
};

const plan = {
  name: "Plan 1",
  description: "description 1",
  deadline: "2021-12-12",
  tasks: [
    {
      name: "Task 1",
      description: "description 1",
      question: "question 1",
      taskDateTime: "2021-12-12",
      promptContext: "promptContext 1",
      id: 1,
    },
    {
      name: "Task 2",
      description: "description 2",
      question: "question 2",
      taskDateTime: "2021-12-12",
      promptContext: "promptContext 2",
      id: 2,
    },
  ],
};

const TaskList = () => {
  const { name, description, tasks, deadline } = plan;

  const { id } = useParams<{ id: string }>();

  return (
    <Box>
      <Heading as="h2" size="lg" mb={3}>
        {name}
      </Heading>
      <Text as="p" mb={5}>
        {deadline}
      </Text>
      <Text as="p">{description}</Text>
      <Grid templateColumns="repeat(auto-fit, minmax(300px, 1fr))">
        {tasks.map((task) => (
          <Task
            name={task.name}
            description={task.description}
            question={task.question}
            taskDateTime={task.taskDateTime}
            promptContext={task.promptContext}
            id={task.id}
            key={task.id}
          />
        ))}
      </Grid>
    </Box>
  );
};

export default TaskList;
