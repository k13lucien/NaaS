CREATE TABLE IF NOT EXISTS decline_path (
                              id BIGSERIAL PRIMARY KEY,
                              code VARCHAR(50) NOT NULL UNIQUE,
                              title VARCHAR(100) NOT NULL,
                              message TEXT NOT NULL,
                              tone VARCHAR(50) NOT NULL
);
