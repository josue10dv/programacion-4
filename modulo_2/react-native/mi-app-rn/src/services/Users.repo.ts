import { UserApi } from "../types/ApiUsers";
import api from "./Api";

const BASE = "/users";

export async function getUsers(): Promise<UserApi[]> {
    const { data } = await api.get<UserApi[]>(BASE);
    return data;
}

export async function getUser(id: number): Promise<UserApi> {
    const { data } = await api.get<UserApi>(`${BASE}/${id}`);
    return data;
}

export async function createUser(payload: UserApi): Promise<UserApi> {
    const { data } = await api.post<UserApi>(BASE, payload);
    return data;
}

export async function updateUser(id: number, payload: UserApi): Promise<UserApi> {
    const { data } = await api.put<UserApi>(`${BASE}/${id}`, payload);
    return data;
}

export async function deleteUser(id: number): Promise<void> {
    await api.delete(`${BASE}/${id}`);
}