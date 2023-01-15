import { useState, useEffect } from "react";
import {
  Box,
  Text,
  Input,
  Card,
  Wrap,
  WrapItem,
  Avatar,
} from "@chakra-ui/react";
import { InfoIcon } from "@chakra-ui/icons";
import axios from "axios";
import { API_URL } from "../../constants";

export interface IMessage {
  message: string;
  isUser: boolean;
}

const Message = ({ message, isUser }: IMessage) => {
  return (
    <Box
      display="flex"
      flexDirection={isUser ? "row-reverse" : "row"}
      alignItems="center"
      padding="0.5em"
    >
      <Card
        padding="0.5em"
        background={isUser ? "var(--blue-bg-400)" : "var(--blue-bg-100)"}
        color={isUser ? "var(--blue-text-400)" : "var(--blue-text-100)"}
        borderRadius="md"
        maxWidth="60%"
      >
        <Wrap display="flex" alignItems="center">
          {isUser ? null : (
            <WrapItem>
              <Avatar size="sm" />
            </WrapItem>
          )}
          <WrapItem>
            <Text fontSize="md">{message}</Text>
          </WrapItem>
        </Wrap>
      </Card>
    </Box>
  );
};

const Chat = () => {
  const [message, setMessage] = useState("");
  const [messages, setMessages] = useState<IMessage[]>([]);
  const [inputDisabled, setInputDisabled] = useState(true);

  const sendMessage = async () => {
    if (message === "") return;
    const result = await axios.post(`${API_URL}/askai`, {
      id: 2137,
      myAnswer: message,
      question: localStorage.getItem("question"),
    });
    setMessage("");
    setMessages([
      ...messages,
      {
        message,
        isUser: true,
      },
      {
        message: result.data,
        isUser: false,
      },
    ]);
    setInputDisabled(true);
  };

  useEffect(() => {
    if (localStorage.getItem("question") === null) {
      window.location.href = "/plans";
    }
    setMessages([
      {
        message: localStorage.getItem("question") || "",
        isUser: false,
      },
    ]);
  }, []);

  return (
    <Box
      display="grid"
      width="clamp(300px, 80vw, 1280px)"
      height="clamp(300px, 80vh, 720px)"
      background="var(--blue-bg-200)"
      color="var(--blue-text-200)"
      gridTemplateRows="auto 1fr auto"
    >
      <Box
        display="flex"
        alignItems="center"
        padding="30px 30px"
        background="var(--blue-bg-400)"
        color="var(--blue-text-400)"
      >
        <InfoIcon marginRight="1ch" />
        <Text fontSize="md">Rozmowa z Bobem</Text>
      </Box>
      <Box overflowY="scroll" padding="30px 30px">
        {messages.map((message, index) => (
          <Message
            key={index}
            message={message.message}
            isUser={message.isUser}
          />
        ))}
      </Box>
      <Box
        background="var(--blue-bg-400)"
        color="var(--blue-text-400)"
        paddingBlock="0.5em"
        textAlign="center"
      >
        <Input
          placeholder="Type your message here..."
          backgroundColor="var(--blue-bg-200)"
          color="var(--blue-text-200)"
          value={message}
          onChange={(e) => setMessage(e.target.value)}
          onKeyPress={(e) => (e.key === "Enter" ? sendMessage() : null)}
          width="90%"
          disabled={inputDisabled}
        />
      </Box>
    </Box>
  );
};

export default Chat;
