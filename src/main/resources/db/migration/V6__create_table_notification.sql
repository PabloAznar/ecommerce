CREATE TABLE IF NOT EXISTS NOTIFICATION(

    notification_id varchar(45) not null primary key,

    description text null,

    user_id varchar(45) not null,

    constraint notification_fk_user_id foreign key (user_id) references USERS(user_id)

);

CREATE INDEX IF NOT EXISTS idx_notification ON notification(user_id);