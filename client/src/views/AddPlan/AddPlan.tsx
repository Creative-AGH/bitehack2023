import styles from "./AddPlan.module.scss";
import { useForm } from "react-hook-form";
import { Link } from "react-router-dom";

import {
  FormErrorMessage,
  FormLabel,
  FormControl,
  Button,
  Heading,
  Text,
  Textarea,
  Box,
  Input,
} from "@chakra-ui/react";

const AddPlan = () => {
  const {
    register,
    handleSubmit,
    formState: { errors, isSubmitting },
  } = useForm();

  function onSubmit(values: any) {
    return new Promise((resolve) => {
      setTimeout(() => {
        alert(JSON.stringify(values, null, 2));
        resolve(true);
      }, 3000);
    });
  }

  return (
    <Box
      background="var(--blue-bg-200)"
      color="var(--blue-text-200)"
      display="grid"
      paddingBlock="40px"
      paddingInline="20px"
      gridTemplateColumns="minmax(clamp(250px, 50vw, 400px), 1fr)"
      maxWidth={500}
    >
      <Heading
        mb={4}
        as="h3"
        size="md"
        background="var(--blue-bg-200)"
        color={"var(--blue-text-200)"}
      >
        Dodawanie nowego materiału
      </Heading>
      <form onSubmit={handleSubmit(onSubmit)}>
        <FormControl isInvalid={errors.prompt ? true : false}>
          <FormLabel htmlFor="prompt">Wklej tekst lub załącz pliki:</FormLabel>
          <Textarea
            placeholder="Here is a sample placeholder"
            minHeight={200}
            id="prompt"
            {...register("prompt", {
              required: "Materiał jes wtymagany",
              value: `
              
              Protisty (łac. Protista) – jedno z pięciu królestw, wyróżnianych w ostatnich hierarchicznych systemach klasyfikacji organizmów (np. w podziałach Whittakera i Margulis oraz Cavaliera-Smitha). Obejmuje wszystkie jądrowce, które pozostały po wyłączeniu organizmów zaliczonych do monofiletycznych kladów zwierząt, roślin i grzybów.

Zgodnie z aktualną wiedzą należy tu zbiór taksonów o bardzo różnych powiązaniach filogenetycznych – cała grupa ma charakter polifiletyczny i parafiletyczny (sztuczny). Nie istnieje żadna zaawansowana ewolucyjnie cecha, która wyróżniałaby protisty od pozostałych eukariontów. Większość protistów to jednokomórkowce, zdarzają się też wielokomórkowce, a nawet organizmy zbliżone do tkankowego poziomu organizacji. Protisty można podzielić na podstawie sposobu odżywiania na autotroficznie, heterotroficzne oraz miksotroficzne.

Rozmnażają się przez podział komórki, czasem jednak spotyka się też rozród płciowy. Wielokomórkowce rozmnażają się za pomocą zarodników (zoospory).

Uważa się, że magazynujący glikogen i zaopatrzeni w wić przedstawiciele królestwa Protista byli przodkami zwierząt.

Protisty to prawdopodobnie najstarsze eukarionty, które pojawiły się w ewolucji ponad 1,5 miliarda lat temu[1]. Według niektórych szacunków wykonanych metodą zegara molekularnego, wspólny przodek eukariontów, będący protistem, żył ok. 2,3 mld lat temu[2]. Interpretacja skamieniałości jest problematyczna, gdyż w niektórych przypadkach sporne jest, czy są one pochodzenia eukariotycznego, czy prokariotycznego. Jedne z najstarszych skamieniałości, co do których eukariotycznego pochodzenia nie ma wątpliwości, pochodzą sprzed ok. 1,6 mld lat, a należą do taksonu Grypania spiralis. Jako Grypania opisywane są również skamieniałości starsze, ale mogą one być pochodzenia prokariotycznego[3]. Ponadto Grypania spiralis była prawdopodobnie glonem, a więc nie we wszystkich systemach zaliczana byłaby do protistów. Nie jest również jasny status skamieniałości Gabonionta sprzed 2,1 mld lat, które mogą być szczątkami eukariontów, ale też tylko pseudoskamieniałościami[4].

Protisty to eukarionty, w większości jednokomórkowe, o zróżnicowanej budowie morfologicznej, o wielkości od 10 μm do kilku milimetrów. W budowie protista można zazwyczaj wyróżnić przód, tył, stronę grzbietową oraz brzuszną. Nie występują tu typowe tkanki. Można jednak wyróżnić w niektórych przypadkach części liściokształtne, łodygokształtne, a nawet korzeniokształtne.

Protisty wykształciły pellikulę, czyli błonę komórkową podścieloną tworami błoniastymi, wzmacniającymi całą konstrukcję. Jej dodatkową właściwością jest duża elastyczność, pozwalającą na poruszanie się ruchem ameboidalnym. Komórki protistów wypełnia cytoplazma, najczęściej podzielona na gęstszą zewnętrzną ektoplazmę oraz rzadszą, ulokowaną centralnie w komórce endoplazmę. W endoplazmie ulokowana jest większość organelli, wśród których należy wymienić: aparat Golgiego, lizosomy, wakuole. W komórce wykształciło się też jądro, mitochondria oraz plastydy.

Protisty mają różne „układy lokomocyjne” i poruszają się za pomocą pełzania, ruchów rzęsek i wici czy błonki falującej.

Pierwotniaki wykształciły różne organella ruchu, dzięki którym mogą poruszać się w celu odnajdywania pokarmu lub ucieczki przed niekorzystnymi warunkami środowiska. Są to:

wić (flagellum), rzęska (cilium) – twory identyczne pod względem konstrukcji, różniące się jednak liczbą, wielkością oraz tym, że rzęski połączone są włókienkami pod warstwą błony komórkowej (pellikuli), co pozwala na skoordynowanie ich ruchów;
nibynóżki (pseudopodia) – wykształcone u niektórych zarodziowców, ich działanie polega na przelewaniu cytoplazmy do różnych rejonów komórki, a co za tym idzie tworzenie uwypukleń czy wypustek komórki; pozwala to na przemieszczanie się ruchem ameboidalnym oraz na „oblewanie” ciała potencjalnej ofiary.
Mogą one również trwale osiadać na dnie zborników wodnych lub swobodnie unosić się w wodzie.

Rodzaj organelli ruchu stanowi jedno z głównych kryteriów podziału protistów na typy:

wiciowce – o stałym kształcie ciała i jednej lub więcej wici;
pełzaki – o zmiennym kształcie ciała i zdolności do wynicowania nibynóżek;
słonecznice – o kulistym ciele i cienkich, promieniście rozchodzących się nibynóżkach;
orzęski – o ciałach pokrytych równoległymi rzędami rzęsek;
sporowce – całkowicie pozbawione narządów ruchu.

Protisty zdolne są do odbioru bodźców zewnętrznych oraz reagowania na nie. Odbywa się to na zasadzie elektrycznej, dzięki polaryzacji błony komórkowej. Niektóre protisty wykształciły specyficzne organella do percepcji wrażeń świetlnych – jak np. czerwona plamka oczna (stigma). Inne natomiast reagują na zmiany prądów wody (reotaksja).



              `,
            })}
          />
          <FormErrorMessage>
            {errors.prompt && String(errors.prompt.message)}
          </FormErrorMessage>
          <Button
            mt={4}
            mb={4}
            color="var(--blue-text-btn)"
            bg={"var(--blue-bg-btn)"}
            _hover={{ bg: "var(--blue-bg-btn-hover)" }}
          >
            Przeglądaj...
          </Button>
          <FormLabel htmlFor="estimatedLearningTime">
            Ilość zapytań nauki:
          </FormLabel>
          <Input
            type="number"
            id="estimatedLearningTime"
            placeholder="Ilość zapytań"
            {...register("estimatedLearningTime", {
              required: "To pole jest wymagane",
              value: 5,
              min: {
                value: 1,
                message: "Minimalna ilość zapytań to 1",
              },
              max: {
                value: 50,
                message: "Maksymalna ilość zapytań to 100",
              },
            })}
            w="100px"
          />
          <FormErrorMessage>
            {errors.estimatedLearningTime &&
              String(errors.estimatedLearningTime.message)}
          </FormErrorMessage>
          <FormLabel htmlFor="deadline">Termin wykonania:</FormLabel>
          <Input
            type="date"
            id="deadline"
            placeholder="Termin wykonania"
            {...register("deadline", {
              required: "To pole jest wymagane",
              min: {
                value: new Date().toISOString().split("T")[0],
                message: "Termin musi być późniejszy niż dzisiaj",
              },
              value: new Date().toISOString().split("T")[0],
            })}
          />
          <FormErrorMessage>
            {errors.deadline && String(errors.deadline.message)}
          </FormErrorMessage>
        </FormControl>
        <Button
          mt={4}
          mb={4}
          color="var(--blue-text-btn)"
          bg={"var(--blue-bg-btn)"}
          isLoading={isSubmitting}
          type="submit"
          _hover={{ bg: "var(--blue-bg-btn-hover)" }}
          w="100%"
        >
          Dodaj materiał
        </Button>
        <hr />
        <Text as="p" textAlign="center" mt={4}>
          Nie masz konta?{" "}
          <Link
            to="/#"
            style={{
              color: "#3182CE",
              fontWeight: "bold",
            }}
          >
            Zarejestruj się
          </Link>
        </Text>
      </form>
    </Box>
  );
};

export default AddPlan;
