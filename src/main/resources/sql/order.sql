CREATE TABLE `order` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `order` (`id`, `order_id`, `status`)
VALUES
  (2, 2, 0);
INSERT INTO `order` (`id`, `order_id`, `status`)
VALUES
  (3, 3, 0);
