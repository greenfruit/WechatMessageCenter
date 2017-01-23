package com.fruit.chat.message.domain.res;

/**
 * <p>DESCRIPTION:  类描述
 * <p>CALLED BY:   zhangshouzheng
 * <p>UPDATE BY:   zhangshouzheng
 * <p>CREATE DATE: 2017/1/22
 * <p>UPDATE DATE: 2017/1/22
 *
 * @version 1.0
 * @since java 1.7.0
 */
public class MusicMessage extends BaseMessage {
    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}
