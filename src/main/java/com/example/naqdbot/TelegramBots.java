package com.example.naqdbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.groupadministration.GetChatMember;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TelegramBots extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "@naqdbot";
    }

    @Override
    public String getBotToken() {
        return "5377783829:AAGSaRwKF0AaLWUIv9u0xiu0yLRhMjPffkA";
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage();
            User user = update.getMessage().getFrom();
            if (message.hasText()) {
                String text = message.getText();
                if (text.equals("/start")) {
                    try {
                        GetChatMember getChatMember = new GetChatMember();
                        getChatMember.setChatId("@dosazimov");
                        getChatMember.setUserId(user.getId());
                        ChatMember chatMember = execute(getChatMember);
                        System.out.println(chatMember.getStatus());

                        GetChatMember getChatMember1 = new GetChatMember();
                        getChatMember1.setChatId("@uzatd");
                        getChatMember1.setUserId(user.getId());
                        ChatMember chatMember1 = execute(getChatMember1);
                        if (chatMember.getStatus().equals("creator")) {
                            System.out.println(chatMember.getStatus());
                        } else if (chatMember.getStatus().equals("member")&&chatMember1.getStatus().equals("member")) {
                            SendMessage sendMessage1 = new SendMessage();
                            sendMessage1.setText("O'yinimiz ishtirokchisiga aylandingiz! " + user.getFirstName());
                            sendMessage1.setParseMode(ParseMode.MARKDOWN);
                            sendMessage1.setChatId(String.valueOf(message.getChatId()));
                            execute(sendMessage1);
                            System.out.println(chatMember.getStatus());
                        } else if (chatMember.getStatus().equals("left")||chatMember1.getStatus().equals("left")) {
                            SendMessage sendMessage = new SendMessage();
                            sendMessage.setText("Assalomu alaykum " + user.getFirstName() + ", UzA rasmiy telegram botiga hush kelibsiz!\n" +
                                    "\n" +
                                    "⛔️ Afsuski siz bizning telegram kanalimizga obuna bo'lmagansiz! Botimizdan to'liq foydalanish uchun iltimos obuna bo'ling!!");
                            sendMessage.setParseMode(ParseMode.MARKDOWN);
                            sendMessage.setChatId(String.valueOf(message.getChatId()));
                            InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                            List<InlineKeyboardButton> inlineKeyboardButtons1 = new ArrayList<>();
                            List<InlineKeyboardButton> inlineKeyboardButtons2 = new ArrayList<>();
                            List<InlineKeyboardButton> inlineKeyboardButtons3 = new ArrayList<>();
                            List<InlineKeyboardButton> inlineKeyboardButtons4 = new ArrayList<>();
                            List<InlineKeyboardButton> inlineKeyboardButtons5 = new ArrayList<>();
                            List<InlineKeyboardButton> inlineKeyboardButtons6 = new ArrayList<>();
                            List<List<InlineKeyboardButton>> rowCollection = new LinkedList<>();
                            InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
                            InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
                            InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
                            InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
                            InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
                            InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
                            inlineKeyboardButton1.setText("➕A'zo bo'lish");
                            inlineKeyboardButton1.setUrl("https://t.me/dosazimov");
                            inlineKeyboardButton2.setText("➕A'zo bo'lish");
                            inlineKeyboardButton2.setUrl("https://t.me/uzatd");
//                            inlineKeyboardButton3.setText("➕A'zo bo'lish");
//                            inlineKeyboardButton3.setUrl("facebook.com/uzauz");
//                            inlineKeyboardButton4.setText("➕A'zo bo'lish");
//                            inlineKeyboardButton4.setUrl("instagram.com/uza.uz");
//                            inlineKeyboardButton5.setText("➕A'zo bo'lish");
//                            inlineKeyboardButton5.setUrl("twitter.com/uzauz");
                            inlineKeyboardButton6.setText("✅A'zo bo'ldim!");
                            inlineKeyboardButton6.setCallbackData("✅A'zo bo'ldim!");
                            inlineKeyboardButtons1.add(inlineKeyboardButton1);
                            inlineKeyboardButtons2.add(inlineKeyboardButton2);
//                            inlineKeyboardButtons3.add(inlineKeyboardButton3);
//                            inlineKeyboardButtons4.add(inlineKeyboardButton4);
//                            inlineKeyboardButtons5.add(inlineKeyboardButton5);
                            inlineKeyboardButtons6.add(inlineKeyboardButton6);
                            rowCollection.add(inlineKeyboardButtons1);
                            rowCollection.add(inlineKeyboardButtons2);
//                            rowCollection.add(inlineKeyboardButtons3);
//                            rowCollection.add(inlineKeyboardButtons4);
//                            rowCollection.add(inlineKeyboardButtons5);
                            rowCollection.add(inlineKeyboardButtons6);
                            inlineKeyboardMarkup.setKeyboard(rowCollection);
                            sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                            execute(sendMessage);
                        }
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }


                }

            }
        } else if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            if (callbackQuery.getData().equals("✅A'zo bo'ldim!")) {
                try {
                    GetChatMember getChatMember = new GetChatMember();
                    getChatMember.setChatId("@dosazimov");
                    getChatMember.setUserId(callbackQuery.getFrom().getId());
                    ChatMember chatMember = execute(getChatMember);
                    System.out.println(chatMember.getStatus());

                    GetChatMember getChatMember1 = new GetChatMember();
                    getChatMember1.setChatId("@uzatd");
                    getChatMember1.setUserId(callbackQuery.getFrom().getId());
                    ChatMember chatMember1 = execute(getChatMember1);
                    if (chatMember.getStatus().equals("creator")) {
                        System.out.println(chatMember.getStatus());
                    } else if (chatMember.getStatus().equals("member")&&chatMember1.getStatus().equals("member")) {
                        SendMessage sendMessage1 = new SendMessage();
                        sendMessage1.setText("O'yinimiz ishtirokchisiga aylandingiz! " + callbackQuery.getFrom().getFirstName());
                        sendMessage1.setParseMode(ParseMode.MARKDOWN);
                        sendMessage1.setChatId(String.valueOf(callbackQuery.getMessage().getChatId()));
                        execute(sendMessage1);
                        System.out.println(chatMember.getStatus());
                    } else if (chatMember.getStatus().equals("left")||chatMember1.getStatus().equals("left")) {
                        SendMessage sendMessage = new SendMessage();
                        sendMessage.setText("⛔️ Afsuski siz ko'rsatilgan barcha telegram kanalimizga obuna bo'lishingiz kerak! " +
                                "Botimizdan to'liq foydalanish uchun iltimos obuna bo'ling!!");
                        sendMessage.setParseMode(ParseMode.MARKDOWN);
                        sendMessage.setChatId(String.valueOf(callbackQuery.getMessage().getChatId()));
                        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
                        List<InlineKeyboardButton> inlineKeyboardButtons1 = new ArrayList<>();
                        List<InlineKeyboardButton> inlineKeyboardButtons2 = new ArrayList<>();
                        List<InlineKeyboardButton> inlineKeyboardButtons3 = new ArrayList<>();
                        List<InlineKeyboardButton> inlineKeyboardButtons4 = new ArrayList<>();
                        List<InlineKeyboardButton> inlineKeyboardButtons5 = new ArrayList<>();
                        List<InlineKeyboardButton> inlineKeyboardButtons6 = new ArrayList<>();
                        List<List<InlineKeyboardButton>> rowCollection = new LinkedList<>();
                        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
                        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
                        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
                        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
                        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
                        InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
                        inlineKeyboardButton1.setText("➕A'zo bo'lish");
                        inlineKeyboardButton1.setUrl("https://t.me/dosazimov");
                        inlineKeyboardButton2.setText("➕A'zo bo'lish");
                        inlineKeyboardButton2.setUrl("https://t.me/uzatd");
//                        inlineKeyboardButton3.setText("➕A'zo bo'lish");
//                        inlineKeyboardButton3.setUrl("facebook.com/uzauz");
//                        inlineKeyboardButton4.setText("➕A'zo bo'lish");
//                        inlineKeyboardButton4.setUrl("instagram.com/uza.uz");
//                        inlineKeyboardButton5.setText("➕A'zo bo'lish");
//                        inlineKeyboardButton5.setUrl("twitter.com/uzauz");
                        inlineKeyboardButton6.setText("✅A'zo bo'ldim!");
                        inlineKeyboardButton6.setCallbackData("✅A'zo bo'ldim!");
                        inlineKeyboardButtons1.add(inlineKeyboardButton1);
                        inlineKeyboardButtons2.add(inlineKeyboardButton2);
//                        inlineKeyboardButtons3.add(inlineKeyboardButton3);
//                        inlineKeyboardButtons4.add(inlineKeyboardButton4);
//                        inlineKeyboardButtons5.add(inlineKeyboardButton5);
                        inlineKeyboardButtons6.add(inlineKeyboardButton6);
                        rowCollection.add(inlineKeyboardButtons1);
                        rowCollection.add(inlineKeyboardButtons2);
//                        rowCollection.add(inlineKeyboardButtons3);
//                        rowCollection.add(inlineKeyboardButtons4);
//                        rowCollection.add(inlineKeyboardButtons5);
                        rowCollection.add(inlineKeyboardButtons6);
                        inlineKeyboardMarkup.setKeyboard(rowCollection);
                        sendMessage.setReplyMarkup(inlineKeyboardMarkup);
                        execute(sendMessage);
                    }
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }


            }
        }
    }
}




