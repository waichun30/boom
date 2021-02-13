CREATE DATABASE boom_workspace;

-- product
-- DROP TABLE IF EXISTS `product`;
CREATE TABLE IF NOT EXISTS `product` (
  `product_code` varchar(64) NOT NULL COMMENT 'product code',
  `product_name` varchar(64) NOT NULL COMMENT 'product name',
  `product_img_path` varchar(128) DEFAULT NULL COMMENT 'product image path',
  `product_description` varchar(64) DEFAULT NULL COMMENT 'product description',
  `product_currency` varchar(3) NOT NULL COMMENT 'product currency',
  `product_amount` bigint(20) NOT NULL COMMENT 'product amount',
  `product_status` varchar(16) NOT NULL COMMENT 'product status',
  `category_code` varchar(16) NOT NULL COMMENT 'category code',
  `created_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT 'created time',
  `modified_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT 'modified time',
  `extend_info` varchar(4096) DEFAULT NULL COMMENT 'key value for extra information',
  PRIMARY KEY (`product_code`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='product table'
;


-- image
-- DROP TABLE IF EXISTS `image`;
CREATE TABLE IF NOT EXISTS `image` (
  `image_code` varchar(64) NOT NULL COMMENT 'image code',
  `product_code` varchar(64) NOT NULL COMMENT 'product code',
  `image_name` varchar(64) NOT NULL COMMENT 'image name',
  `image_type` varchar(16) NOT NULL COMMENT 'image type',
  `image_path` varchar(1024) NOT NULL COMMENT 'image url path',
  `created_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT 'created time',
  `modified_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT 'modified time',
  `extend_info` varchar(4096) DEFAULT NULL COMMENT 'key value for extra information',
  PRIMARY KEY (`image_code`),
  KEY `idx_merchant_product` (`merchant_code`, `product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='image table'
;


-- order
-- DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `order_code` varchar(64) NOT NULL COMMENT 'order code',
  `order_amount` int(11) NOT NULL DEFAULT  0 COMMENT 'order_amount',
  `pay_amount` int(11) NOT NULL DEFAULT  0 COMMENT 'pay_amount',
  `change_amount` int(11) NOT NULL DEFAULT  0 COMMENT 'change_amount',
  `order_status` varchar(16) NOT NULL COMMENT 'order status',
  `created_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT 'created time',
  `modified_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT 'modified time',
  `extend_info` varchar(4096) DEFAULT NULL COMMENT 'key value for extra information',
  PRIMARY KEY (`order_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='order table'
;

-- order item
-- DROP TABLE IF EXISTS `order_product`;
CREATE TABLE IF NOT EXISTS `order_product` (
  `order_product_code` int(10) NOT NULL AUTO_INCREMENT COMMENT 'order product code',
  `order_code` varchar(64) NOT NULL COMMENT 'order code',
  `product_code` varchar(64) NOT NULL COMMENT 'product code',
  `quantity` varchar(64) NOT NULL COMMENT 'quantity',
  `memo` varchar(64) NOT NULL COMMENT 'memo',
  `created_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT 'created time',
  `modified_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT 'modified time',
  `extend_info` varchar(4096) DEFAULT NULL COMMENT 'key value for extra information',
  PRIMARY KEY (`order_product_code`)  ,
  KEY `idx_order_code` (`order_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='order product table'
;

-- event log
-- DROP TABLE IF EXISTS `event_log`;
CREATE TABLE IF NOT EXISTS `event_log` (
  `id` varchar(64) NOT NULL COMMENT 'primary key',
  `type` varchar(64) NOT NULL COMMENT 'type',
  `content` varchar(1024) NOT NULL COMMENT 'content',
  `status` varchar(64) NOT NULL COMMENT 'status',
  `memo` varchar(1024) NOT NULL COMMENT 'memo',
  `created_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT 'created time',
  `modified_time` timestamp(6) NOT NULL DEFAULT CURRENT_TIMESTAMP(6) ON UPDATE CURRENT_TIMESTAMP(6) COMMENT 'modified time',
  `extend_info` varchar(4096) DEFAULT NULL COMMENT 'key value for extra information',
  PRIMARY KEY (`id`),
  KEY `idx_type` (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='event log table'
;
