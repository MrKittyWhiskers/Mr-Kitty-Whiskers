package org.mkw.game;

public class CollisionEvent {

	private Entity entity;
	
	public CollisionEvent(Entity entity) {
		this.entity = entity;
	}
	
	public void setEntity(Entity entity) {
		this.entity = entity;
	}
	
	public Entity getEntity() {
		return entity;
	}
	
}
