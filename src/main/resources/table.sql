CREATE TABLE category (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    disposalGuidelines VARCHAR(500),
    recyclingTips VARCHAR(500)
);