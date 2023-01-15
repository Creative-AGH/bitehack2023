import { Grid, GridItem, Heading, Progress } from "@chakra-ui/react";
import { AddIcon } from "@chakra-ui/icons";
import icon from "../../assets/icons/BiAlarmExclamation.png";
import { useNavigate } from "react-router-dom";

export interface IPlanContainer {
  name: string;
  deadline: string;
  progress: number;
  id: number;
}

const plans = [
  {
    name: "Plan 1",
    deadline: "2021-12-12",
    progress: 81,
    id: 1,
  },
  {
    name: "Plan 2",
    deadline: "2021-12-12",
    progress: 50,
    id: 2,
  },
  {
    name: "Plan 3",
    deadline: "2021-12-12",
    progress: 20,
    id: 3,
  },
];

const PlanContainer = ({ name, deadline, progress, id }: IPlanContainer) => {
  const navigate = useNavigate();
  return (
    <GridItem
      bg="var(--blue-bg-300)"
      color="var(--blue-text-300)"
      p={4}
      mt={5}
      borderRadius="md"
      onClick={() => navigate(`/plan/${id}`)}
      _hover={{
        cursor: "pointer",
      }}
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
          {deadline}
        </span>
      </div>
      <Progress
        hasStripe
        mt={5}
        colorScheme={progressColor(progress)}
        value={progress}
      />
    </GridItem>
  );
};

const progressColor = (progress: number) => {
  if (progress < 50) {
    return "red";
  } else if (progress < 80) {
    return "yellow";
  } else {
    return "green";
  }
};

const AddPlaceDotted = () => {
  const navigate = useNavigate();
  return (
    <GridItem
      color="var(--blue-text-200)"
      p={4}
      mt={5}
      borderRadius="md"
      border="5px dashed var(--blue-bg-400)"
      display="grid"
      placeItems="center"
      onClick={() => navigate("/add")}
      _hover={{
        cursor: "pointer",
      }}
    >
      <AddIcon boxSize={6} />
      <h1>Dodaj nowy plan</h1>
    </GridItem>
  );
};

const ViewPlans = () => {
  return (
    <Grid
      templateColumns="repeat(auto-fill, minmax(300px, 1fr))"
      gap={6}
      w="100%"
      paddingInline={10}
    >
      <AddPlaceDotted />
      {plans.map((plan) => (
        <PlanContainer {...plan} />
      ))}
    </Grid>
  );
};

export default ViewPlans;
