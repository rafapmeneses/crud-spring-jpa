import { useAxios } from "./use-axios.hook"

export function useHttp(baseURL, headers) {
  const instance = useAxios(baseURL, headers)

  async function get(url) {
    const response = await instance.get(url)
    return response?.data
  }

  async function post(url, data) {
    const response = await instance.post(url, data)
    return response?.data
  }

  async function postLogin(url, _, headers) {
    const response = await instance.post(url, _, headers)
    return response?.headers["x-auth-token"]
  }

  async function put(url, data) {
    const response = await instance.put(url, data || {})
    return response?.data
  }

  async function del(url) {
    const response = await instance.delete(url)
    return response
  }

  return {
    get,
    post,
    postLogin,
    put,
    del
  }
}
