package com.github.fsnork.jrtelegrambot.jrtb.repository.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Telegram User entity.
 */
@Data
@Entity
@Table(name = "tg_user")
public class TelegramUser {
}
